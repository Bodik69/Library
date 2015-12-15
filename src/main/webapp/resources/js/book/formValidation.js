$(document).ready(function() {
    var currentTime = new Date();
    var year = currentTime.getFullYear();
    $.validator.addMethod("numbers", function(value, element) {
        return this.optional(element) || /^[0-9]+$/i.test(value);
    }, "Numbers only");
    $("#addBook").validate({
        rules: {
            title: {
                required: true
            },
            edition: {
                required: true
            },
            year: {
                required: true,
                numbers: "required only numbers",
                min: 0,
                max: year + 1
            },
            pages: {
                numbers: "required only numbers",
                required: true
            },
            copyCount: {
                numbers: "required only numbers",
                required: true
            }
        }
    });
});
