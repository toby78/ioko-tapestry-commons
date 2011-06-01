Tapestry.Initializer.overlayMixinLoad = function(isForm, overlayId, containerId, exposeColour) {
    var overlay = jQuery(document.getElementById(overlayId));
    var container = jQuery(document.getElementById(containerId));
    var expose = (exposeColour != 'none');

    jQuery(function() {
        overlay.overlay({
                    speed: 'fast',
                    fadeInSpeed: 'fast'
                });
        if (expose) {
            overlay.mask = { color: exposeColour };
        }
        if (isForm == 'true') {
            container.submit(function(event) {
                overlay.overlay().load();
            });
        } else {
            container.click(function(event) {
                overlay.overlay().load();
            });
        }
    });
};
