$(document).ready(function () {
    var clicked = null;
    $(".addCopy").click(function () {
        if ($(this).text() === "-") {
            clicked.html("+");
            clicked = null;
            $(".countForm").remove();
        } else {
            if (clicked !== null) {
                clicked.html("+");
                $(".countForm").remove();
            }
            clicked = $(this);
            var url = "book/add/" + $(this).attr('id');
            $(this).html("-");
            $(this).after("<div class='countForm group'>"
                + "<form id='count-copy-form' action=" + url + " method='post'>"
                + "<input type='text' name='count' onkeypress='return event.charCode >= 48 && event.charCode <= 57' required><input type='submit' class='btn btn-primary' value='Додати'>"
                + "</form></div>");
        }
    });
});