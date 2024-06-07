  window.addEventListener("load", () =>{
	    document.querySelectorAll(".delete").forEach(item => {
	        const div = item.closest("div[data-code]");

	        item.addEventListener("click", e => {
	            e.preventDefault(); // 기본 동작을 막음

	            fetch("http://localhost:9091/mypage/delete_image/" + div.dataset.code, {
	                method: "GET",
	            })
	            .then(resp => {
	                if(resp.ok) {
	                    div.remove();
	                } else {
	                    // Handle error if needed
	                    console.error("Failed to delete image.");
	                }
	            });
	        });
	    });
	});