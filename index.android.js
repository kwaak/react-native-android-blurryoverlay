var { requireNativeComponent, PropTypes, View } = require('react-native');

var iface = {
    name: 'BlurryOverlay',
    propTypes: {
+        ...View.propTypes,
        radius: PropTypes.number,
        sampling: PropTypes.number,
        color: PropTypes.string,
    },
};

module.exports = requireNativeComponent('RCTBlurryOverlay', iface);