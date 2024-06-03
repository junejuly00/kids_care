document.addEventListener('DOMContentLoaded', function() {
    const buttons = document.querySelectorAll('.tab-button');
    const contents = document.querySelectorAll('.tab-content');
    const innerButtons = document.querySelectorAll('.inner-button');
    const innerContents = document.querySelectorAll('.inner-content');

    function showContent(targetId, contentCollection, buttonsCollection) {
        contentCollection.forEach(content => {
            content.classList.remove('active');
            if (content.id === targetId) {
                content.classList.add('active');
            }
        });

        if (buttonsCollection) {
            buttonsCollection.forEach(button => {
                button.classList.remove('active');
                if (button.getAttribute('data-target') === targetId) {
                    button.classList.add('active');
                }
            });
        }
    }

    buttons.forEach(button => {
        button.addEventListener('click', function() {
            const targetId = this.getAttribute('data-target');
            showContent(targetId, contents, buttons);

            // If the last button (content6) is clicked, show the first inner content by default
            if (targetId === 'content6' && innerButtons.length > 0) {
                showContent(innerButtons[0].getAttribute('data-target'), innerContents, innerButtons);
            }
        });
    });

    innerButtons.forEach(button => {
        button.addEventListener('click', function() {
            const targetId = this.getAttribute('data-target');
            showContent(targetId, innerContents, innerButtons);
        });
    });

    // 첫 번째 버튼의 내용을 기본적으로 표시
    if (buttons.length > 0) {
        buttons[0].click();
    }
});