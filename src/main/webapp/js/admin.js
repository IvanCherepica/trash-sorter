$('#sendSelectedCategory').on('click', function () {
    $.ajax({
        method: 'POST',
        url: '/admin/edit',
        data: {
            tankId: $_GET('id'),
            itemType: $_GET('item'),
            ids: JSON.stringify(getSelectedIds())
        },
        success: function(response){
            console.log('succes')
        },
        error: function (e) {
            console.log(e);
        }
    });
});

function getSelectedIds() {
    var values = [];

    $('input[type="checkbox"]:checked').each(function() {
        values.push($(this).val());
    });

    return values;
}
var selected;
$('#clicker').on('click', function () {

    var values = [];
    $('input[type="checkbox"]:checked').each(function() {
        values.push($(this).val());
    });
    console.log(values);
});

function $_GET(key) {
    var p = window.location.search;
    p = p.match(new RegExp(key + '=([^&=]+)'));
    return p ? p[1] : false;
}