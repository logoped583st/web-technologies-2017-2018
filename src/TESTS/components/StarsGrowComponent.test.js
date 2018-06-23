import React from 'react';
import { shallow, mount, configure } from 'enzyme';
import { shallowToJson, mountToJson } from 'enzyme-to-json';
import { HashRouter } from 'react-router-dom';
import Adapter from 'enzyme-adapter-react-16';
import configureStore from 'redux-mock-store';
import thunk from 'redux-thunk';
import TabsStarsGrowReposComponent from '../../components/StarsGrowReposComponent';

configure({ adapter: new Adapter() });

describe('UserRepositories component test', () => {
    const mockStore = configureStore([thunk]);
    const initialState = {
        reducerUser: {
            login: 'logoped583st'
        },
        reducerRepos: [
            {
                name: 'adgfds',
                html_url: 'http://KAAAAKAA/',
                language: 'C#',
                private: true,
            },
            {
                name: 'logos',
                html_url: 'http://KAAAAKAA/',
                language: 'Java',
                private: false,
            },
        
        ]
    }

    let store;

    beforeEach(() => {
        store = mockStore(initialState);
    })

    it('UserRepositories component rendered succesfully', () => {
        const userRepositories = mount(
            <HashRouter>
                <TabsStarsGrowReposComponent store={store} />
            </HashRouter>
        );
        expect(mountToJson(userRepositories)).toMatchSnapshot();
    });

    
    it('UserRepositories rendered without user login', () => {
        const fakeInitialState = {
            reducerUser: {
                login: ''
            },
            reducerRepos: [
                {
                    name: 'asdasd',
                    html_url: 'http://KAAAAKAA/',
                    language: 'Java',
                    private: true,
                },

                
            ]
        }
        const fakeStore = mockStore(fakeInitialState);
        const userRepositories = mount(
            <HashRouter>
                <TabsStarsGrowReposComponent store={fakeStore} />
            </HashRouter>
        );
        expect(userRepositories.prop('login')).toBe(undefined);
        expect(userRepositories.prop('reducerRepos')).toBe(undefined);
        expect(mountToJson(userRepositories)).toMatchSnapshot();
    })
});