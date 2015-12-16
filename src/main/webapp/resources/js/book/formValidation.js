$(document).ready(function() {
    var currentTime = new Date();
    var year = currentTime.getFullYear();
    jQuery.validator.addMethod("lettersonly", function(value, element) {
        return this.optional(element) || /^[a-zA-Zа-яА-ЯіІїЇєЄґҐ]+$/i.test(value);
    });
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
                digits: true,
                min: 0,
                max: year + 1
            },
            pages: {
                digits: true,
                required: true
            },
            copyCount: {
                digits: true,
                required: true
            },
            "author.firstName": {
                lettersonly: true,
                required: function(element) {
                    return $("#author\\.lastName").val().length !== 0;
                }
            },
            "author.lastName": {
                lettersonly: true,
                required: function(element) {
                    return $("#author\\.firstName").val().length !== 0;
                }

            }
        },
        messages: {
            title: {
                required: "Обов'язкове поле"
            },
            edition: {
                required: "Обов'язкове поле"
            },
            year: {
                required: "Обов'язкове поле",
                min: "Недопустиме значення року",
                maxlength: "Книга буде видана у майбутьньому",
                digits: "Тільки цифри"
            },
            pages: {
                required: "Обов'язкове поле",
                digits: "Тільки цифри"
            },
            copyCount: {
                required: "Обов'язкове поле",
                digits: "Тільки цифри"
            },
            "author.firstName": {
                lettersonly: "Тільки букви",
                required: "Якщо є прізвище, то повинно бути і ім\'я"
            },
            "author.lastName": {
                lettersonly: "Тільки букви",
                required: "Якщо є ім\'я, то повинно бути і прізвище"
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
    $(".alert-danger").fadeTo(2000, 500).slideUp(500, function(){
        $(".alert-danger").alert('close');
    });
}
