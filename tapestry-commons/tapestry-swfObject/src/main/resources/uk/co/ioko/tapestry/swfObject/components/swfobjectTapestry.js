Tapestry.Initializer.swfObject = function(spec) {
    swfobject.embedSWF(spec.swf,
            spec.clientId,
            spec.width,
            spec.height,
            spec.version,
            spec.expressInstall,
            spec.flashVars,
            spec.params,
            spec.attributes);
}
