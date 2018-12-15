class ApplicationController < ActionController::Base
  helper_method :current_user_session, :current_user, :logged_in?

  private

    def current_user_session
      return @current_user_session if defined? @current_user_session

      if ENV["RAILS_ENV"] == "test"
        User.create(username: "tester", email: "tester@mail.org", password: "secretive", password_confirmation: "secretive")
        @current_user_session = UserSession.create(username: "tester", password: "secret")
      end

      @current_user_session = UserSession.find
    end

    def current_user
      return @current_user if defined? @current_user
      @current_user = current_user_session && current_user_session.user
    end

    def logged_in?
      !!current_user_session
    end

    def require_login
      redirect_to signin_path unless logged_in?
    end

    def require_logout
      redirect_to dashboard_path if logged_in?
    end

    def require_customer
      unless current_user.customer?
        flash[:notice] = "Unauthorized access."
        redirect_to dashboard_path
      end
    end

    def require_admin
      unless current_user.admin?
        flash[:notice] = "Unauthorized access."
        redirect_to dashboard_path
      end
end

    def require_specific(user)
      unless current_user == user
        flash[:notice] = "Unauthorized access."
        redirect_to dashboard_path
      end
    end
end
