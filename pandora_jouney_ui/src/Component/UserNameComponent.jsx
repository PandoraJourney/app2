import React, {Component} from 'react'
import {injector} from 'react-services-injector'

class UserNameComponent extends Component {
   constructor() {
       super();
       this.handleUsernameChange = this.handleUsernameChange.bind(this);
        this.state =  { username: "Default" };
      }    
      componentDidMount() {
       
        this.setState({ username: "Juozas" });
      }
    
      handleUsernameChange(e) {
       const {UserService} = injector.get();
        var username = e.target.value;
        UserService.setUser(username);
       this.setState({ username: username });
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
                />
            </div>
        );
    }

} 

export default injector.connect(UserNameComponent);