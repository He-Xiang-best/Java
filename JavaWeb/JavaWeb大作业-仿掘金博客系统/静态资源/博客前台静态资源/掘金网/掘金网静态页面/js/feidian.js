$('.action-box .action').click(function () {
    $('.login-pop').removeAttr('style')
});
$(document).scroll(function () {
    if($(this).scrollTop() > 300) {
        $('header').css('transform','translateY(-100%)')
        // $('main .main-list').css('top',0)
        $('.pin-side').css({
            position:'fixed',
            right:'286px',
        })
    }else {
        $('header').removeAttr('style')
        // $('main .main-list').css('top',60)
        $('.pin-side').css({
            position:'static',
        })
    }
})
$('.dock-nav .nav-item').click(function(){
    // var index=$(this).index();
    $(this).addClass('active1').siblings().removeClass('active1')
    // $('.books-list').eq(index).addClass('active2').siblings().removeClass('active2')
})