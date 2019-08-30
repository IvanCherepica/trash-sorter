
function decode(){
    let reader;
    document.getElementById('inputGroupFile01').addEventListener('change', async function(){
        if(!reader){
            reader = await Dynamsoft.BarcodeReader.createInstance();
        }
        reader.decode(this.files[0]).then(results => {
            if (results.length > 0) {
                console.log(results);
                var txts = [];
                for (var i = 0; i < results.length; ++i) {
                    txts.push(results[i].BarcodeText);
                }
                var barCode = txts.join("\n");

                $.ajax({
                    method: 'post',
                    url: '/worker',
                    data: {'barCode': barCode},
                    success:  function(t) {
                        if (t.isvalidate) {
                            $('#barcode').text(t.barcode),
                            $('#nametrash').text(t.name),
                            $('#exampleModal').modal('show');
                        } if (t.isvalidate == false) {
                            $('#errorModal').modal('show');
                        }



                    },
                    error: function (e) {
                        console.log(e)
                    }
                })

                this.value = '';






            }
            else
            {
                alert("No barcode found.");
                this.value = '';
            }
        });
    });
}

$(document).ready(function () {
    $('#inputGroupFile01').on('click', function () {
        decode();
    })
})

                    