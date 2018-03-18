import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './index.css';
import ProductListContainer from './Container/ProductListContainer'
import ProductDetailsContainer from './Container/ProductDetailsContainer'
import CartDetailsContainer from './Container/CartDetailsContainer'
import ProductListAdministrationContainer from './Container/ProductListAdministrationContainer'
import ProductAdministrationContainer from './Container/ProductAdministrationContainer'
import { Router, Route, IndexRoute, hashHistory } from 'react-router'
import {injector} from 'react-services-injector';
import services from './Service/UserService';

injector.register(services);

var NoMatch = (props) => {
  return <div>Route did not match</div>;
};

class Admin extends Component {
  render() {
    return (<div>{this.props.children}</div>);
  }
}

ReactDOM.render(
  <Router history={hashHistory}>
    <Route path="/" component={App}>
      <IndexRoute component={ProductListContainer} />
      <Route path="/institution-list" component={ProductListContainer} />
      <Route path="/institution/:name" component={ProductDetailsContainer} />
      <Route path={"/book-details"} component={CartDetailsContainer} />
      <Route path="/admin" component={Admin} >
        <IndexRoute component={ProductListAdministrationContainer} />
        <Route path="/books/new" component={ProductAdministrationContainer} />
        <Route path="/books/:productId" component={ProductAdministrationContainer} />
      </Route>
      <Route path="*" component={NoMatch} />
    </Route>

  </Router>,
  document.getElementById('root')
);

