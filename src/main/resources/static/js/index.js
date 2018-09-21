Vue.component('component-list', {
    props: ['messages'],
    template: '<div>' +
    '   <div v-for="message in messages">' +
    '       <div>{{message.text}}</div>' +
    '   </div>' +
    '</div>'
})

var app = new Vue({
    el: "#container",
    data: {
        messages: []
    },
    mounted: function() {
        axios.get('/message')
            .then( response => this.messages = response.data )
            .catch(function (error) {
                // handle error
                console.log(error);
            })
    }
})