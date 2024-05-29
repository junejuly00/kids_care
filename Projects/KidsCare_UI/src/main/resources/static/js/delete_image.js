document.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll(".delete").forEach(item => {
        const div = item.closest("div[data-code]");
        item.addEventListener("click", e => {
            fetch("/kcuserpost/delete_image/" + div.dataset.code, {
                method: "GET",
            })
            .then(resp => resp.text())
            .then(result => {
                if(result === "OK") {
                    div.remove(); // 전체 이미지 컨테이너 제거
                } else {
                    alert("이미지 삭제에 실패했습니다."); // 실패 시 알림
                }
            })
            .catch(error => {
                alert("오류가 발생했습니다: " + error.message); // 네트워크 오류 처리
            });
         });
       });
    });
