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
            $(this).after("<span class='countForm group'>"
                + "<form id='count-copy-form' action=" + url + " method='post'>"
                + "<input type='text' name='count'><input type='submit' value='Додати'>"
                + "</form></span>");
        }
    });
});