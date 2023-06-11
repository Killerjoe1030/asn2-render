// defining some constants
var minGPA = 0.0 
var maxGPA = 4.33
var allGPAs = []
var allHeights = []
var allWeights = []


// for addStudent.html
// button to receive user input for a new student object
var button = document.querySelector('input[value=SUBMIT]')
// button.addEventListener('click',function(evt){
//     evt.preventDefault()

//     var newName = document.getElementById("name").value 
//     console.log(newName)

//     var newWeight = document.getElementById("weight").value 
//     console.log(newWeight)

//     var newHairColour = document.getElementById("hair_colour").value
//     console.log(newHairColour)

//     var newHeight = document.getElementById("height").value 
//     console.log(newHeight)

//     var newGPA = document.getElementById("gpa").value 
//     if(newGPA < minGPA || newGPA > maxGPA){
//         console.log("Invalid Input!")
//     }
//     else{
//         console.log(newGPA)
//         array.push(newGPA)
//     }
// })

//old contents of addStudent()
    // var newName = document.getElementById("name").value 
    // if(newName == ""){
    //     console.log("hello")
    //     return
    // }

    // console.log(newName)

    // var newWeight = document.getElementById("weight").value 
    // console.log(newWeight)

    // var newHairColour = document.getElementById("hair_colour").value
    // console.log(newHairColour)

    // var newHeight = document.getElementById("height").value 
    // console.log(newHeight)

    // var newGPA = document.getElementById("gpa").value 
    // if(newGPA < minGPA || newGPA > maxGPA){
    //     console.log("Invalid Input!")
        
    // }
    // else{
    //     console.log(newGPA)
    //     array.push(newGPA)
    // }

function grabthing(){
    var thing = document.getElementById("hello").value
    console.log(thing)

}

function addStudent(){

    var newName = document.getElementById("name").value 
    console.log(newName)

    var newGPA = document.getElementById("gpa").value 
    console.log(newGPA)
    allGPAs.push(newGPA)

    var newHeight = document.getElementById("height").value
    console.log(newHeight)
    allHeights.push(newHeight)

    var newWeight = document.getElementById("weight").value 
    console.log(newWeight)
    allWeights.push(newWeight)

}
