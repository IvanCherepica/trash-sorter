
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<div style="background-color:#f8f8f8;border-bottom:1px solid #eee;margin-bottom:10px;padding:20px;">
    <style type="text/css">
        div,p,h1,a{font-family: "Helvetica Neue",Helvetica,Roboto,Arial,sans-serif;}
        .btn-download{display:inline-block;margin-top:18px;padding: 10px 20px;text-decoration:none;font-size: 16px;color: #fe8e14;border: 2px solid #fe8e14;border-radius: 3px;text-align: center;transition: all .2s ease-in-out;font-family:"Helvetica Neue",Helvetica,Roboto,Arial,sans-serif;}
        .btn-download:hover{color: #ffae38;border-color: #ffae38;}
        .a-codeGallery{font-size:14px;text-decoration:none;color:#50a8e1;}
        .a-codeGallery:hover{color:#5ebbd7;}
    </style>

    <div style="width:980px;height:482px;margin:auto;">
        Choose a file to upload and decode barcode(s): <input id="uploadImage" type="file" accept="image/bmp,image/jpeg,image/png,image/gif,application/pdf,image/tiff">
        <div id="divLog" style="height:400px;"></div>
    </div>
    <div><img id="image" ></div>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script>
        document.getElementById('uploadImage').addEventListener('change', function(){
            var files = this.files;
            var fd = new FormData();
            fd.append('img', files[0]);
            $('#image')
            $('#divLog').html('');
            $('#divLog').append('<p>=== uploading ===</p>');
            var barCode;
            $.ajax({
                method: 'POST',
                url: 'decodeBarcode.jsp',
                data: fd,
                async: false,
                processData: false,
                contentType: false,
                success: function(response){
                    for(var i = 0; i < response.length; ++i){
                        $('#divLog').append('<br>');
                        var pIndex = document.createElement('p');
                        $(pIndex).text('Barcode '+(i+1));
                        $('#divLog').append(pIndex);
                        var pVal = document.createElement('p');
                        $(pVal).attr('id', 'testId');
                        $(pVal).text(''+response[i].barcodeText);
                        $('#divLog').append(pVal);
                    }
                }
            });
            barCode = $('#testId').text();
            $.ajax({
                method: 'POST',
                url: 'http://localhost:8080/worker',
                data: {'barCode': barCode}
            })
        })
    </script>
    </div>
<div>
    <input type="number" id="bar_code_id" placeholder="Barcode" required="required" name="barcode">
    <input type="button" id="button_id" value="Press me">
</div>

<div id="result">

</div>

<script>
    $('#button_id').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/worker',
            data:{
                barcode: $('#bar_code_id').val()
            },
            success: function (data) {
                $('#result').empty();
                getAllModels();
            },
            error: function (error) {
                console.log('Error!')
            }
        });

    });

    function getAllModels() {
        $.ajax({
            type: 'GET',
            url: '/worker',
            success: function (data) {
                for (var i in data){
                    var barcode = data[i];
                    $('#result').append('<p>' + barcode + '</p>');
                }
                console.log('ok in GET');
            },
            error: function (e) {
                console.log(e);
            }
        });

        console.log()
    }
</script>
<a href="/login">Admin</a>
</body>
</html>
