function colorpickerfield_change_color_field_value(cfId) {
    var val = jQuery('#' + cfId + ' :selected').val();
    if (val == -1 || val == "") {
        jQuery('#' + cfId).css('color', '');
    } else {
        jQuery('#' + cfId).css('color', jQuery('#' + cfId + " option:selected").attr("current-color"));
    }
}