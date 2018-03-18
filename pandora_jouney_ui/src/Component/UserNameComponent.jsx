import React, {Component} from 'react'
import {injector} from 'react-services-injector'

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
          e.preventDefault();
          let {UserService} = injector.get();
          UserService.setUser(this.username);
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