$(document).ready(function() {
    $.validator.addMethod("numbers", function(value, element) {
        return this.optional(element) || /^[0-9]+$/i.test(value);
    });
    $("#valideOrder").validate({
        rules: {
            "copy.id": {
                required: true,
                digits: true
            },
            "reader.idReader": {
                required: true,
                digits: true
            }
        },

        messages: {
            "copy.id": {
                required: "Обов'язкове поле",
                digits: "Неправильний формат!Тільки цифри!"
            },
            "reader.idReader": {
                required: "Обов'язкове поле",
                digits: "Неправильний формат! Тільки цифри!"
            }
        }


    });
});