$(document).ready(function() {
    $('#deleteChecked').hide();
    $('.checkbox').click(function () {
        var checked_status = this.checked;
        if (checked_status == false) {
            var isHide = true;
            $(".checkbox").each(function (index) {
                if(this.checked == true) {
                    isHide = false;
                    return false;
                }
            });
            if(isHide == true) {
                $('#deleteChecked').hide();
            }
        }
        else {
            $('#deleteChecked').show();
        }

    });
});