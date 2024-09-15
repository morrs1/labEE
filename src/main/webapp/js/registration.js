document.getElementById("registration-form").addEventListener("submit", function(event){
    event.preventDefault();

    const formData = new FormData(this);

    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    console.log(JSON.stringify(data));

    fetch('/registration', {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then()



})