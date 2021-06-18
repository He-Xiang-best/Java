$(document).ready(function () {
    var swiper = new Swiper(`.swiper-container`, {
        autoplay:true,
        loop: true,
        pagination: {
            el: '.swiper-pagination',
            clickable :true,
            bulletClass : 'my-bullet',//需设置.my-bullet样式
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });

    // 鼠标进入停止轮播
    $('.swiper-container').hover(function () {
        swiper.autoplay.stop();
    },function () {
        swiper.autoplay.start();
    });

    new Calendar({
        parent: 'calendar',
        pickMode: 'single',
    })

    $(document).scroll(function () {
        if($(this).scrollTop() > 300) {
            $('header').css('transform','translateY(-100%)')
            $('main .main-list').css('top',0)
        }else {
            $('header').removeAttr('style')
            $('main .main-list').css('top',60)
        }
    })
});
