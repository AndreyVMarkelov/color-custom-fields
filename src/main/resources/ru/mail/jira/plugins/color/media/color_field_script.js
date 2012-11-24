function ru_mail_change_color_field_value(cfId) {
    var selector = '#' + cfId + ' :selected';
    var val = jQuery('#' + cfId + ' :selected').val();
    if (val == -1 || val == "") {
        jQuery('#' + cfId).css('color', '');
    } else {
        jQuery('#' + cfId).css('color', val);
    }
}