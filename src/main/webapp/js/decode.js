
function decode(){

    let reader;
    document.getElementById('inputGroupFile01').addEventListener('change', async function(){
        if(!reader){
            reader = await Dynamsoft.BarcodeReader.createInstance();
        }
        $('#exampleModal').modal('show');
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
                            $('#name').text(t.name);
                            $('#barcode').text(t.barcode);
                            $('#a1').empty().append(`<p><strong>Наименование чая: </strong><div id="name"></div></p><p><strong>Штрихкод: </strong><div id="barcode"></div></p><p><strong>Это тот товар:</strong></p><p><button type="button"  Style="width:100%" class="btn btn-success" onclick="$('#a1').empty().prepend('<h4><strong>ВЫ МОЖЕТЕ ВЫКИДЫВАТЬ МУСОР\\'</h4></strong>').prepend($('<img>',{id:'#a1',src:'img/yes.png'}));" data-dismiss="modal">Да</button></p><p><button type="button"  Style="width:100%" class="btn btn-danger" onclick="$('#a1').empty().prepend('<h4><strong>ВЫ НЕ МОЖЕТЕ ВЫКИДЫВАТЬ МУСОР\\'</h4></strong>').prepend($('<img>',{id:'#a1',src:'img/no.png'}));" data-dismiss="modal" >Нет</button></p>`);

                        }
                    },
                })
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

                    