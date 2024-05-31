window.addEventListener("load", () =>{
    document.querySelectorAll(".delete").forEach(item => {
        const div = item.closest("div[data-code]");

        item.addEventListener("click", e => {
            fetch("/kcuserpost/delete_image/" + li.dataset.code, {
                method: "GET",
            })
            .then(resp => resp.text())
            .then(result => {
                if(result == "OK") 
                    li.remove();
            });
        })
    })
})