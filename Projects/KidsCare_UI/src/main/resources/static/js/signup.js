function signup(){
  const form = document.info;
  const regExp = /^(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$/; // 비밀번호 조건 최소 8자 이상으로 숫자, 특수문자가 각각 최소 1개이상

  if(!form.id.value || form.id.value == ''){
      alert("아이디를 입력해 주세요.");
      form.id.focus();
      return;
  }

if(!check_id){
  alert("아이디 중복 확인을 하세요.");
  return;
}

if(!form.passwd.value || form.passwd.value == ''){
  alert("비밀번호를 입력 하세요.");
  form.passwd.focus();
  return;
}

if(!form.check_pw.value || form.check_pw.value == ''){
  alert("비밀번호 확인을 입력 하세요.");
  form.check_pw.focus();
  return;
}

if(!regExp.test(form.passwd.value)) {
  alert("비밀번호는 숫자와 특수문자를 포함하여 8자 이상으로 입력해 주세요.");
  form.custid.focus();
  return;
}

if(!form.name.value || form.name.value == ''){
  alert("이름을 입력해 주세요.");
  form.name.focus();
  return;
}

if(!form.phone.value || form.phone.value == ''){
  alert("전화번호를 입력해 주세요.");
  form.phone.focus();
  return;
}

if(!form.address.value || form.address.value == ''){
  alert("주소를 입력해 주세요.");
  form.address.focus();
  return;
}
form.submit();
};