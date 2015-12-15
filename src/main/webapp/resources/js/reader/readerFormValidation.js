$(document).ready(function() {
    $(".addReader").validate({
        rules: {
            name: {
                required: true
            },
            surname: {
                required: true

            },
            adress: {
                required: true
            },
            phone: {
                required: true,
                minlength: 10,
                maxlength: 12,
                digits: true

            },
            birth: {
                required: true,
                dateISO: true
            }
        },

        messages: {
            name: {
                required: "Обов'язкове поле"
            },
            surname: {
                required: "Обов'язкове поле"
            },
            adress: {
                required: "Обов'язкове поле"
            },
            phone: {
                required: "Обов'язкове поле",
                minlength: "Мінімальна кількість символів 10",
                maxlength: "Максимальна кількість символів 12",
                digits: "Тільки цифри"
            },
            birth: {
                required: "Обов'язкове поле",
                dateISO: "Некоректна дата. Формата дати: 2010-12-10"
            }
        }


    });
});
