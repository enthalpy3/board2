
function check() {

	var id = $("#id");
	var pw = $("#pw");
	var pw2 = $("#pw2");
	var name = $("#name");
	var phone = $("#phone");
	var email = $("#email");
	var recommender = $("#recommender");

	/* 영어, 숫자만 허용 특수문자 제외 */
	var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;
	if (!idReg.test($("input[name=id]").val())) {
		alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
		return false;
	}

	/* 비밀번호는 영문 숫자 특수문자만 허용 */
	var pwReg = /^[a-zA-Z`~!@#$%^&*|\\\'\";:\/?0-9]{8,20}$/g;
	if (!pwReg.test($("input[name=pass]").val())) {
		alert("8~20자 영문자 또는 숫자이어야 합니다. 특수문자가능");
		return false;
	} else if ($("#pass").val() != $("#pass2").val()) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}

	/* 이름 한글만 가능 */
	var nameReg = /^[가-힣]{2,10}$/g;
	if (!nameReg.test($("input[name=name]").val())) {
		alert("2~10자 한글만 사용할수 있습니다.");
		return false;
	}

	/* 추천인한글만 가능 */
	var recommenderReg = /^[가-힣]{2,10}$/g;
	if (!recommenderReg.test($("input[name=recommender]").val())) {
		alert("2~10자 한글만 사용할수 있습니다.");
		return false;
	}

	/* 숫자만 가능 */
	var phoneReg = /^[0-9]{11}$/g;
	if (!phoneReg.test($("input[name=phone]").val())) {
		alert("-를 제외한 숫자이어야 합니다.");
		return false;
	}
	/* @ 이를 포함 영어와 숫자만 가능 */
	var emailReg = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/g;
	if (!emailReg.test($("input[name=email]").val())) {
		alert("올바른 형식이 아닙니다.");
		return false;
	}

};