var { requireNativeComponent, PropTypes } = require('react-native');

var iface = {
    name: 'BlurryOverlay',
    propTypes: {
        radius: PropTypes.number,
        sampling: PropTypes.number,
        color: PropTypes.string,
    },
};

module.exports = requireNativeComponent('RCTBlurryOverlay', iface);