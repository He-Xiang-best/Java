$('.nav-list1 .active').click(function(){
    var index=$(this).index();
    $(this).addClass('active1').siblings().removeClass('active1')
    $('.books-list').eq(index).addClass('active2').siblings().removeClass('active2')
})

    $('#search').focus(function () {
        $(this).parent('.search-form').css('border-color', '#007fff');
        $(this).next('img').attr('src', 'https://b-gold-cdn.xitu.io/v3/static/img/juejin-search-icon-focus.470748c.svg')
    })
    $('#search').blur(function () {
        $(this).parent('.search-form').removeAttr('style');
        $(this).next('img').attr('src', 'https://b-gold-cdn.xitu.io/v3/static/img/juejin-search-icon.6f8ba1b.svg')
    })
    $(document).scroll(function () {
        if($(this).scrollTop() > 300) {
            $('header').css('transform','translateY(-100%)')
            $('.view-nav').css('top',0)
        }else {
            $('header').removeAttr('style')
            $('.view-nav').css('top',60)
        }
    })
    