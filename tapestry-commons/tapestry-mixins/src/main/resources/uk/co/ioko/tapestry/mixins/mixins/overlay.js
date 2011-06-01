Tapestry.Initializer.overlayMixinLoad = function(spec) {


    var overlay = jQuery(document.getElementById(spec.overlayId));
    var container = jQuery(document.getElementById(spec.containerId));
    var expose = (spec.exposeColour != 'none');

    jQuery(function() {
        overlay.overlay({
                    speed: 'fast',
                    fadeInSpeed: 'fast'
                });
        if (expose) {
            overlay.mask = { color: spec.exposeColour };
        }
        if (spec.isForm == 'true') {
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
