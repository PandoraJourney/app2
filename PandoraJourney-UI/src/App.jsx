import React, { Component } from 'react'
import {Link } from 'react-router'
import CartSummaryContainer from './Container/CartSummaryContainer'
import UserNameComponent from './Component/UserNameComponent';
import {injector} from 'react-services-injector';

class App extends Component {
  
  render() {
  //  const {Storage} = injector.get();
    return (
      <div className="container">
        <div className="row">
          <div className="col-sm-10 col-md-12">
            <nav className="navbar navbar-inverse">
              <div className="container-fluid">
                <div className="navbar-header">
                  <Link className="navbar-brand" to="/institution-list" activeStyle={{ color: 'red' }} >Home</Link>
                </div>
                <ul className="nav navbar-nav">
                  <li className="active"><Link to="/books" activeStyle={{ color: 'red' }}>Admin</Link></li>
                </ul>
                <form className="navbar-form navbar-left" action="/action_page.php">
                  <UserNameComponent />
                </form>
                <ul className="nav navbar-nav navbar-right">
                  <li><Link to="/cart-details"><CartSummaryContainer/></Link></li>
                </ul>
              </div>
            </nav>
          </div>
        </div>
        {this.props.children}
      </div>
    );
  }
}
export default App;