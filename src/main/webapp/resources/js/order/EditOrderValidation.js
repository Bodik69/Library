$(document).ready(function() {
    $.validator.addMethod("numbers", function(value, element) {
        return this.optional(element) || /^[0-9]+$/i.test(value);
    });
    $("#valideOrderEdit").validate({
        rules: {
            "copy.id": {
                required: true,
                digits: true
            },
            "reader.idReader": {
                required: true,
                digits: true
            },
            dataOrder: {
                required:true,
                dateISO: true
            },
            dataReturn: {
                dateISO: true
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
            },

            dataOrder: {
                required: "Обов'язкове поле",
                dateISO: "Некоректна дата. Формата дати: 2010-12-10"
            },

            dataReturn: {
                dateISO: "Некоректна дата. Формата дати: 2010-12-10"
            }
        }

    });
});