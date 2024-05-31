document.addEventListener('DOMContentLoaded', function() {
    const buttons = document.querySelectorAll('.tab-button');
    const contents = document.querySelectorAll('.tab-content');

    function showContent(targetId) {
        contents.forEach(content => {
            content.classList.remove('active');
            if (content.id === targetId) {
                content.classList.add('active');
            }
        });

        buttons.forEach(button => {
            button.classList.remove('active');
            if (button.getAttribute('data-target') === targetId) {
                button.classList.add('active');
            }
        });
    }

    buttons.forEach(button => {
        button.addEventListener('click', function() {
            const targetId = this.getAttribute('data-target');
            showContent(targetId);
        });
    });

    // 첫 번째 버튼의 내용을 기본적으로 표시
    if (buttons.length > 0) {
        buttons[0].click();
    }
});