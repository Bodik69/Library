$(document).ready(function() {
    jQuery.validator.addMethod("lettersonly", function(value, element) {
        return this.optional(element) || /^[a-zA-Zа-яА-ЯіІїЇєЄґҐ]+$/i.test(value);
    });
    $("#addReader").validate({
        rules: {
            name: {
                required: true,
                lettersonly: true
            },
            surname: {
                required: true,
                lettersonly: true

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
                required: "Обов'язкове поле",
                lettersonly: "Тільки букви"
            },
            surname: {
                required: "Обов'язкове поле",
                    lettersonly: "Тільки букви"
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
        },
        highlight: function(element) {
            $(element).closest('.group').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function(error, element) {
            if(element.parent('.form-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        }
    });
});

function showAlert(){
    $(".alert-danger").fadeTo(5000, 500).slideUp(500, function(){
        $(".alert-danger").alert('close');
    });
}
