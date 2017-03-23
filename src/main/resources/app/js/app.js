'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom')
const rest = require('rest');
const mime = require('rest/interceptor/mime');

const client = rest.wrap(mime);
// end::vars[]

// tag::app[]
class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {beers: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/beer'}).done(response => {
            this.setState({beers: response.entity});
    });
}

render() {
    return (
        <BeerList beers={this.state.beers}/>
)
}
}
// end::app[]

// tag::employee-list[]
class BeerList extends React.Component{
    render() {
        console.log(this.props.beers);
        var beers = this.props.beers.map(beer =>
            <Beer key={beer.id} beer={beer}/>
);
    return (
        <table>
        <tbody>
        <tr>
            <th>Name</th>
            <th>Strength</th>
        </tr>
        {beers}
        </tbody>
        </table>
)
}
}
// end::employee-list[]

// tag::employee[]
class Beer extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.beer.name}</td>
                <td>{this.props.beer.strength}</td>
            </tr>
)
}
}
// end::employee[]

// tag::render[]
ReactDOM.render(
<App />,
    document.getElementById('react')
)
// end::render[]

