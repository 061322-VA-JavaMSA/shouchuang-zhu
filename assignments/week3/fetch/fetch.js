// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

/*
    - When button is clicked, send http request to API for a specific id
    - get the id value from input box
    - send request to PokeAPI
        - Method: GET
        - Headers: None
        - Body: None
        - url: https://pokeapi.co/api/v2/pokemon/ + id from input box
    - might have to convert JSON to JS object
    - populate the data in Section
*/
let baseApiURL = 'https://pokeapi.co/api/v2/pokemon';

async function getData() {
    console.log('Button was clicked!');
    let id = document.getElementById('dataInput').value;
    console.log(`id = ${id}`);

    let httpResponse = await fetch(`${baseApiURL}/${id}`);

    if(httpResponse.status >= 200 && httpResponse.status < 300){
    let data = await httpResponse.json();
    
    populateData(data);
    
    } else {
        console.log('Invalid request.');
    }
}

function populateData(response) {
    //let arr = [response.name, response.weight, response.id]

    //const ul = document.createElement('ul');
    // arr.forEach(element => {
    //     const li = document.createElement('li');
    //     li.textContent = element;
    //     ul.appendChild(li);
    // });

    let obj = {
        name: response.name,
        weight: response.weight,
        id: response.id
    }
    const ul = document.createElement('ul');
    
    const li = document.createElement('li');
    li.textContent = `name: ${obj.name}`;
    ul.appendChild(li);

    const li2 = document.createElement('li');
    li2.textContent = `weight: ${obj.weight}`;
    ul.appendChild(li2);

    const li3 = document.createElement('li');
    li3.textContent = `id: ${obj.id}`;
    ul.appendChild(li3);
    

    
    document.querySelector('#list').appendChild(ul);
}