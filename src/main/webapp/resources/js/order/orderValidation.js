$(document).ready(function() {
    jQuery.validator.addMethod("lettersonly", function(value, element) {
        return this.optional(element) || /^[a-zA-Zа-яА-ЯіІїЇєЄґҐ]+$/i.test(value);
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

            },

            messages: {
                "copy.id": {
                    required: "Обов'язкове поле",
                    digits: "Тільки цифри"
                },
                "reader.idReader": {
                    required: "Обов'язкове поле",
                    digits: "Тільки цифри"
                }

            }
        }
    });
});