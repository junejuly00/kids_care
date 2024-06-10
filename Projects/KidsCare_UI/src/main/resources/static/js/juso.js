const fullAddr = document.querySelector('#address');
const province = document.querySelector('#province');
const city = document.querySelector('#city');
const village = document.querySelector('#village');
const extra = document.querySelector('#extra');

const onClickSearch = () => {
    new daum.Postcode({
        oncomplete: function(data) {
            fullAddr.value = data.address;
            province.value = data.sido;
            city.value = data.sigungu;
            village.value = data.bname;
            extra.focus();
        }
    }).open();
};

document.getElementById('address-btn').addEventListener('click', function() {
	onClickSearch();
});