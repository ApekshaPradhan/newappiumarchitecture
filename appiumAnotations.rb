$VERBOSE = nil
require 'appium_lib'
require 'test/unit'

# Configure call to Appium Server
# More information is available at http://appium.io/slate/en/master/?ruby#appium-server-capabilities.
class LoginClass < Test::Unit::TestCase

 def setup
   
    server_url = "https://us.pcloudy.com/quickappium/wd/hub"

    caps = {}
    caps['pCloudy_ApiEndpoint'] = 'https://device.pcloudy.com'
    caps['pCloudy_Username'] = 'apeksha.pradhan@sstsinc.com'
    caps['pCloudy_ApiKey'] = 'jy59zmhzfmg9vfsnp4qyc4sn'
    caps['pCloudy_ApplicationName'] = 'pCloudyAppiumDemo.apk'
    caps['pCloudy_DurationInMinutes'] = '5'
    caps['platformName'] = 'Android'
    caps['pCloudy_DeviceFullName'] = 'Lenovo_VibeZ2Pro_Android_5.0.2'
    caps['pCloudy_DeviceVersion'] = '8.1.0'
    caps['pCloudy_DeviceManafacturer'] = "Google"
    caps['newCommandTimeout'] = '600'
    caps['launchTimeout'] = '90000'
    caps['appPackage'] = 'com.pcloudy.appiumdemo'
    caps['appActivity'] = 'com.ba.mobile.LaunchActivity'
   

    appium_driver = Appium::Driver.new({
                                           'caps' => caps,
                                           'appium_lib' => {
                                               :server_url => server_url
                                           }}, true)


    driver = appium_driver.start_driver
    Appium.promote_appium_methods Object
    
 end

 def test_login
    driver.find_element(:id => 'com.pcloudy.appiumdemo:id/accept').click
    sleep(2)
    puts 'Accept Button Clicked'
    driver.find_element(:id => 'com.pcloudy.appiumdemo:id/flightButton').click
    sleep(2)
    puts 'Booked a flight button clicked'
    driver.find_element(:id => 'com.pcloudy.appiumdemo:id/spinnerfrom').click
    sleep(2)
    puts 'from drop down clicked'
    driver.find_element(:xpath => "//android.widget.CheckedTextView[@text='Bangalore, India (BLR)']").click
    sleep(2)
    puts 'from location selected'
    driver.find_element(:id => 'com.pcloudy.appiumdemo:id/spinnerto').click
    sleep(2)
    puts 'to drop down clicked'
    driver.find_element(:xpath => "//android.widget.CheckedTextView[@text='Pune, India (PNQ)']").click
    sleep(2)
    puts 'to location selected'
    driver.find_element(:id => 'com.pcloudy.appiumdemo:id/singleTrip').click
    sleep(2)
    puts 'radio button for single trip clicked'
    driver.find_element(:id => 'com.pcloudy.appiumdemo:id/txtdepart',:text => 'Departs').click
    sleep(2)
    puts 'departure is clicked'
    driver.find_element(:id => 'android:id/button1',:text => 'OK').click
    sleep(2)
    puts 'depature date is selected'
    driver.find_element(:id => 'com.pcloudy.appiumdemo:id/spinnerflight').click
    sleep(2)
    puts 'flight class drop down is clicked'
    driver.find_element(:id => 'android:id/text1',:text => 'Premium Economy').click
    sleep(2)
    puts 'flight class premium economy is selected'
    driver.find_element(:id => 'com.pcloudy.appiumdemo:id/spinnerticket').click
    sleep(2)
    puts 'spinner ticket drop down is clicked'
    driver.find_element(:id => 'android:id/text1',:text => 'Lowest').click
    sleep(2)
    puts 'lowest spinner ticket is selected'
    driver.find_element(:id => 'com.pcloudy.appiumdemo:id/searchFlights').click
    sleep(2)
    puts 'Search flights Button Clicked'
    puts "Tests Succeeded"
 end

 def teardown
    driver.quit
 end

end

