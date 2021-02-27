$(document).ready(function () {
    const nameSelector = $('input[name ="name"]');
    const emailSelector = $('input[name ="email"]');
    const messageSelector = $('textarea[name ="message"]');
    const buttonSelector = $('#submit-button');
    const errorInputClass = "_error-input";
    nameSelector.keyup(function () {
        const nameClass = nameSelector.attr('class');
        if (nameClass.includes(errorInputClass)) {
            nameSelector.removeClass(errorInputClass)
            buttonSelector.attr('disabled', false).css('opacity', '1');
        }
    })

    emailSelector.keyup(function () {
        const emailClass = emailSelector.attr('class');
        if (emailClass.includes(errorInputClass)) {
            emailSelector.removeClass(errorInputClass)
            buttonSelector.attr('disabled', false).css('opacity', '1');
        }
    })

    messageSelector.keyup(function () {
        const messageClass = messageSelector.attr('class');
        if (messageClass.includes(errorInputClass)) {
            messageSelector.removeClass(errorInputClass)
            buttonSelector.attr('disabled', false).css('opacity', '1');
        }
    })
});
