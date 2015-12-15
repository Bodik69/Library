$(document).ready(function() {
    $("#addBook").validate({
        rules: {
            title: {
                required: true
            },
            edition: {
                required: true
            },
            year: {
                required: true
            },
            pages: {
                required: true
            },
            copyCount: {
                required: true
            }
        }
    });
});
