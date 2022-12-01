

function myFunction() {
  document.getElementById("demo3").innerHTML = "Paragraph changed.";
}

function displayDate() {
  document.getElementById('demo').innerHTML = Date();
}

const url = 'http://localhost:8080/getInfo'
const url2 = 'http://localhost:8080/PlayerPlacedCard'

async function testingData(){
    const response = await fetch(url)
    console.log("Logging data")
    console.log(response)
    if(response.ok){
        document.getElementById("testTestFile").innerHTML = response.json();
        console.log("Received a response from spring boot")
        console.log(response.url)
    } else{
        document.getElementById("testTestFile").innerHTML = "response was not okay";
    }

}

function playerCardFunction() {
    console.log(document.getElementById('playerCardField').value)
    if(document.getElementById('playerCardField').value != ""){
        document.getElementById("playerCardWarning").innerHTML = "Card was sent";

        const cardValue = document.getElementById('playerCardField').value;
        const cardUrl = url2 + "/" + cardValue;
        console.log(cardUrl)
        const response = fetch(cardUrl)
        console.log(response)

        document.getElementById('playerCardField').value = "";

    } else {
        document.getElementById("playerCardWarning").innerHTML = "No Card was selected";
        document.getElementById('playerCardField').value = "";
        window.location.reload(true);

    }

}

function discardPileCardFunction(){

    if(document.getElementById('discardPileText').value != ""){
        const discardPileValue = document.getElementById('discardPileText').value;
        const discardURL = 'http://localhost:8080/discardPileRiggeing/' + discardPileValue;
        const response = fetch(discardURL)
        console.log(response)
        document.getElementById("playerCardWarning").innerHTML = "Discard pile was updated";

    } else {
        document.getElementById("playerCardWarning").innerHTML = "No Card was selected";

    }
}

function loadDoc() {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("testTestFile").innerHTML =
    this.responseText;
  }
  xhttp.open("GET", "D:\\Users\\Riyanson\\Documents\\School\\Masters\\Fall 2022\\COMP 5104\\Assignments\\Assignment 3\\Assignment3-Code\\Assignment3\\src\\main\\resources\\static\\testTextFile.txt");
  xhttp.send();
}