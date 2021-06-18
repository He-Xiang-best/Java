$(function ($) {
    $('#search').focus(function () {
        $(this).parent('.search-form').css('border-color', '#007fff');
        $(this).next('img').attr('src', 'https://b-gold-cdn.xitu.io/v3/static/img/juejin-search-icon-focus.470748c.svg')
    });
    $('#search').blur(function () {
        $(this).parent('.search-form').removeAttr('style');
        $(this).next('img').attr('src', 'https://b-gold-cdn.xitu.io/v3/static/img/juejin-search-icon.6f8ba1b.svg')
    });

    $(document).scroll(function (e) {
        if ($(this).scrollTop() > 400) {
            $('.fixed-btn .top').show()
        } else {
            $('.fixed-btn .top').hide()
        }
    });

    $('.fixed-btn .top').click(function () {
        $('html').scrollTop(0);
    });

    $('.auth .login').click(function () {
        $('#signIn').removeAttr('style')
    });
    $('.auth .register').click(function () {
        $('#register').removeAttr('style')
    });

    $('#signIn_close').click(function () {
        $('#signIn').css('display', 'none')
    });

    $('#register_close').click(function () {
        $('#register').css('display', 'none')
    });




});

function changePanda(url) {
    if (url) {
        $('.panda-img img').attr('src', url);
    } else {
        $('.panda-img img').attr('src', 'https://b-gold-cdn.xitu.io/v3/static/img/normal.0447fe9.png');
    }
}
