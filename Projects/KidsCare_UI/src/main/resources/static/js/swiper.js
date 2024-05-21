var swiper = new Swiper(".swiper", {
    slidesPerView: 1,
    spaceBetween: 30,
    speed : 1000,
    loop: true,
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
        renderBullet: function (index, className) {
          return '<span class="' + className + '">' + "</span>";
        },
      },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
    autoplay: {
        delay: 6500,
  },
});