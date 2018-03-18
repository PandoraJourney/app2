import React, {Component} from 'react'
import {injector} from 'react-services-injector'
// import axios from 'axios';

class UserNameComponent extends Component {
   constructor() {
       super();
       this.handleUsernameChange = this.handleUsernameChange.bind(this);
        this.state =  { username: "" };
      }    

      handleUsernameChange(e) {
        let username  = e.target.value;
        console.log({username});
       this.setState({ username: username });
      }  
      
      onSubmit = (e)=>{
            const {UserService} = injector.get();
            UserService.setUser(this.state.name);
            this.setState( {name :UserService.user});
            // axios.post('http://localhost:8081/api/users/' + this.state.name, this.state.name)
            // .then(response => {
                
            // })  
            // .catch(error => {
            //     console.log(error);
            // })
            e.preventDefault();
          console.log(UserService.get());
      }

    render() {
        return (
            <div className="form-group">
                <input
                    type="text"
                    className="form-control"
                    placeholder="Username"
                    value={this.state.username}
                    onChange={this.handleUsernameChange}
                    onSubmit={this.onSubmit}
                />
            </div>
        );
    }

} 


export default injector.connect(UserNameComponent);