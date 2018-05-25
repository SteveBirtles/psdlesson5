function renderMessage(message) {
    return  `<div class="border border-primary p-2 m-2">` +
                `<div>` +
                    `<span class="badge badge-primary mr-2">${message.author}</span>` +
                    `<span class="badge badge-info">${message.postDate}</span>` +
                `</div>` +
                `<div class="py-2 mx-2">${message.text}</div>` +
            `</div>`;
}

function loadMessages() {
    let messagesHTML = '';
    $.ajax({
        url: '/message/list',
        type: 'GET',
        success: function (messageList) {
            for (let message of messageList) {
                console.log(message);
                messagesHTML += renderMessage(message);
            }
            $('#messages').html(messagesHTML);
        }
    });

}
