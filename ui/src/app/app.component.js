import templateUrl from './app.component.html'

export default {
  templateUrl,
  controllerAs: '$app',
  controller:
    /* @ngInject */
    class AppController {
      constructor ($log) {
        $log.debug('AppController instantiated')
        this.message = 'booooo'
      }
    }
}
