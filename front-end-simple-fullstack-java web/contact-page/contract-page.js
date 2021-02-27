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

    function checkEmpty(nameValue, emailValue, messageValue) {
        if (nameValue === '' || emailValue === '' || messageValue === '') {
            if (nameValue === '') {
                nameSelector.addClass(errorInputClass);
                nameSelector.val("");
            }
            if (emailValue === '') {
                emailSelector.addClass(errorInputClass);
                emailSelector.val("");
            }
            if (messageValue === '') {
                messageSelector.addClass(errorInputClass);
                messageSelector.val("");
            }
            return false;
        }
        return true;
    }

    function checkEmail(emailValue) {
        // Check email
        const pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i
        if (!pattern.test(emailValue)) {
            emailSelector.addClass(errorInputClass);
            return false;
        }
        return true
    }

    $('#form').submit(function () {
        // Get the name value and trim it
        const nameValue = $.trim(nameSelector.val());
        const emailValue = $.trim(emailSelector.val());
        const messageValue = $.trim(messageSelector.val());
        // Check if empty or not
        let isEmpty = checkEmpty(nameValue, emailValue, messageValue);
        let isEmailValid = checkEmail(emailValue);
        if (isEmpty || !isEmailValid) {
            buttonSelector.attr('disabled', true).css('opacity', '0.7');
            return false;
        }
        return true;
    })
});
