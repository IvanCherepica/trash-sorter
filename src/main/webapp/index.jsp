
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Trashsorter</title>
    <script src="https://cdn.jsdelivr.net/npm/dynamsoft-javascript-barcode@7/dist/dbr.min.js" data-productKeys="t0068NQAAABlYrAlwmz2H9BHvuIS4k0Q+zj50En/ivBru9D5GH26Q4uTzr30pdAenDwBAmm3HU28X4ltHqXoEL22UeVLoeDw="></script>
    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="css/landing-page.min.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-light bg-light static-top">
    <div class="container">
        <a class="navbar-brand" href="#">Trashsorter</a>

        <a class="btn btn-primary" href="#">Войти</a>
    </div>
</nav>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Информация о мусоре</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6"><p><strong>Изображение товара </strong></p>
                            <p><img src="img/1.jpg"></div>
                        <div class="col-md-6"><p><strong> </strong>Информация о товаре: </strong><br /><div id="nametrash"></div></p>
                            <p><strong>Штрихкод: </strong><div id="barcode"></div></p>
                            <p><strong>Это тот товар:</strong></p>
                            <p><button type="button" Style="width:100%" class="btn btn-success" onclick="$('#target1').toggle();">Да</button></p>
                            <p><button type="button" Style="width:100%" class="btn btn-danger" onclick="$('#target2').toggle();" >Нет</button></p></div>
                    </div>
                    <div class="row">
                        <p><br /></p>
                        <div class="col-md-6" id="target1" style="display:none"><p><br /></p>	<button type="button" class="btn btn-success" Style="width:100%">Вы можете выкинуть</button></div>
                        <div class="col-md-6" id="target2" style="display:none"><p><br /></p>	<p><button type="button" class="btn btn-danger" Style="width:100%">Вам нельзя выкидывать</button></div>

                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal" >Закрыть</button>

            </div>
        </div>
    </div>
</div>

<div class="modal" tabindex="-1" id="errorModal" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Неправильный мусор</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p><button type="button" class="btn btn-danger" height="50" Style="width:100%"><strong>ВЫ НЕ МОЖЕТЕ ВЫКИДЫВАТЬ</strong></button></p>
            </div>
            <div class="modal-footer">

                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<!-- Masthead -->
<header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                    <h2 class="mb-5">Загрузите фото штрихкода, чтобы узнать можно ли а выкинуть</h2>
                    <label for="inputbutton" class="uploadButton">Загрузить файл</label>
                        <div id ="inputbutton">
                    <p class="lead mb-0"><input  id="iptDecodeImg" onclick="decode()" type="file" accept="image/bmp,image/jpeg,image/png,image/gif"></p>
                        </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                    <h2 class="mb-5">Пошаговая инструкция по сервису</h2>
                    <ul>
                        <li>Выберите фото со штрихкодом или сфотографируйте шрихкод на мусоре
                        </li>
                        <li>Загрузите изображение черех кнопку "Загрузить" либо из фотоальбома, либо сфоткаться
                        </li>
                        <li>Откроется дополнительное окно, для потверждения информации о мусоре
                        </li>
                        <li>После подтверждения придет уведомление можно выкинуть или нет
                        </li>
                    </ul>


                </div>
            </div>

        </div>
    </div>
</header>
<section class="features-icons bg-light text-center">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h1>Полезная информация о компании</h1>
                    <p class="lead mb-0">Выберите фото со штрихкодом или сфотографируйте шрихкод на мусоре</p>
                    <p class="lead mb-0">Загрузите изображение черех кнопку "Загрузить"</p>
                    <p class="lead mb-0">Откроется дополнительное окно, для потверждения информации о мусоре</p>
                    <p class="lead mb-0">После подтверждения придет уведомление можно выкинуть или нет</p>
                    <p class="lead mb-0">Выберите фото со штрихкодом или сфотографируйте шрихкод на мусоре</p>
                    <p class="lead mb-0">Загрузите изображение черех кнопку "Загрузить"</p>
                    <p class="lead mb-0">Откроется дополнительное окно, для потверждения информации о мусоре</p>
                    <p class="lead mb-0">После подтверждения придет уведомление можно выкинуть или нет</p>

            </div>


        </div>
    </div>
</section>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Image Showcases -->
<section class="showcase">
    <div class="container-fluid p-0">
        <div class="row no-gutters">

            <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('img/bg-showcase-1.jpg');"></div>
            <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                <h2>Бак по бумаге</h2>
                <p class="lead mb-0">Выберите фото со штрихкодом или сфотографируйте шрихкод на мусоре</p>
                <p class="lead mb-0">Загрузите изображение черех кнопку "Загрузить"</p>
                <p class="lead mb-0">Откроется дополнительное окно, для потверждения информации о мусоре</p>
                <p class="lead mb-0">После подтверждения придет уведомление можно выкинуть или нет</p>
                <p class="lead mb-0">Выберите фото со штрихкодом или сфотографируйте шрихкод на мусоре</p>
                <p class="lead mb-0">Загрузите изображение черех кнопку "Загрузить"</p>
                <p class="lead mb-0">Откроется дополнительное окно, для потверждения информации о мусоре</p>
                <p class="lead mb-0">После подтверждения придет уведомление можно выкинуть или нет</p>
            </div>
        </div>
        <div class="row no-gutters">
            <div class="col-lg-6 text-white showcase-img" style="background-image: url('img/bg-showcase-2.jpg');"></div>
            <div class="col-lg-6 my-auto showcase-text">
                <h2>Бак по стеклу</h2>
                <p class="lead mb-0">Выберите фото со штрихкодом или сфотографируйте шрихкод на мусоре</p>
                <p class="lead mb-0">Загрузите изображение черех кнопку "Загрузить"</p>
                <p class="lead mb-0">Откроется дополнительное окно, для потверждения информации о мусоре</p>
                <p class="lead mb-0">После подтверждения придет уведомление можно выкинуть или нет</p>
                <p class="lead mb-0">Выберите фото со штрихкодом или сфотографируйте шрихкод на мусоре</p>
                <p class="lead mb-0">Загрузите изображение черех кнопку "Загрузить"</p>
                <p class="lead mb-0">Откроется дополнительное окно, для потверждения информации о мусоре</p>
                <p class="lead mb-0">После подтверждения придет уведомление можно выкинуть или нет</p>
            </div>
        </div>
        <div class="row no-gutters">
            <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('img/bg-showcase-3.jpg');"></div>
            <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                <h2>Бак по пластмасе</h2>
                <p class="lead mb-0">Выберите фото со штрихкодом или сфотографируйте шрихкод на мусоре</p>
                <p class="lead mb-0">Загрузите изображение черех кнопку "Загрузить"</p>
                <p class="lead mb-0">Откроется дополнительное окно, для потверждения информации о мусоре</p>
                <p class="lead mb-0">После подтверждения придет уведомление можно выкинуть или нет</p>
                <p class="lead mb-0">Выберите фото со штрихкодом или сфотографируйте шрихкод на мусоре</p>
                <p class="lead mb-0">Загрузите изображение черех кнопку "Загрузить"</p>
                <p class="lead mb-0">Откроется дополнительное окно, для потверждения информации о мусоре</p>
                <p class="lead mb-0">После подтверждения придет уведомление можно выкинуть или нет</p>
            </div>
        </div>
    </div>
</section>





<!-- Footer -->
<footer class="footer bg-light">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 h-100 text-center text-lg-left my-auto">

                <p class="text-muted small mb-4 mb-lg-0">&copy; 2019 год. Все права зашищены</p>
            </div>

        </div>
    </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="jquery/jquery.min.js"></script>
<script src="js/decode.js"></script>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>

